package expression;

import java.util.Scanner;
/*
 * this program aims to use recursion to calculate the value of expression in bracket "()"
 * it provides operations including + - * / % ( )
 * you can calculate  many expressions one line by one line
 * if you want to stop it ,just input 0  
 */
public class expression {
	private static String expression;
	private static char[] exp;
	private static int index;
	private static int len;
	/*
	 * find the preference of all operators 
	 */
	private static int prefer(char t){ //计算优先级
		int p=1;
		switch(t){
		case'+':p=1; break; 
		case'-':p=1; break;
		case'*':p=2; break;
		case'/':p=2; break;
		case'%':p=2; break;
		default:
			break;
		}
		return p;
	}
	/*
	 * calculate the sub-expression's value 
	 */
	private static int calc(){ //计算表达式的值
		int[] digit=new int[3];
		char[] operator=new char[3];
		int dig_num=0;
		int op_num=0;

		/*
		 * use index to indicate the position the program are dealing with
		 * with sub-expression found, calculate it recursively 
		 */
		while(index<len && exp[index]!=')' ){
			if(exp[index]=='('){
				index++;
				digit[dig_num]=calc();
			}
			else if(exp[index]>= '0' && exp[index]<='9'){
				digit[dig_num]*=10;
				digit[dig_num]+=exp[index]-'0';
			}
			else{
				operator[op_num]=exp[index];
				op_num++;
				dig_num++;
			}
			index++;

			if(index>len){
				System.out.println(digit[0]);
				return digit[0];
			}
			/*
			 * all above is used to record the operators and digits and their amounts
			 * and there won't be more than 3 operators or digits
			 * because when calculating 
			 * 3+4+5  --->  7+5
			 * 3+4*5  --->  3+20
			 * 3*4+5  --->  12+5
			 * 3*4*5  --->  12*5
			 * if there are 3 operators, there must be 2 digits who can be calculated.
			 * and if there is a bracket, we will recursively calculate the expression in the bracket
			 * the it will return a number,at that time,we can deal with it in the way above 
			 */
			while(op_num>=2 && prefer(operator[op_num-2])>=prefer(operator[op_num-1])){
				switch(operator[op_num-2]){
				case '+':digit[dig_num-2]=digit[dig_num-2]+digit[dig_num-1];break;
				case '-':digit[dig_num-2]=digit[dig_num-2]-digit[dig_num-1];break;
				case '%':digit[dig_num-1]=digit[dig_num-1]%digit[dig_num];break;
				case '/':digit[dig_num-2]=digit[dig_num-2]/digit[dig_num-1];break;
				case '*':digit[dig_num-2]=digit[dig_num-2]*digit[dig_num-1];break;
				}
				operator[op_num-2]=operator[op_num-1];
				digit[dig_num-1]=0;
				dig_num--;
				op_num--;
			}
		}
		while(op_num>0){
			switch(operator[op_num-1]){
			case '+':digit[dig_num-1]=digit[dig_num-1]+digit[dig_num];break;
			case '-':digit[dig_num-1]=digit[dig_num-1]-digit[dig_num];break;
			case '%':digit[dig_num-1]=digit[dig_num-1]%digit[dig_num];break;
			case '/':digit[dig_num-1]=digit[dig_num-1]/digit[dig_num];break;
			case '*':digit[dig_num-1]=digit[dig_num-1]*digit[dig_num];break;
			}
			dig_num--;
			op_num--;
			
		}
		//System.out.println(digit[0]);
		return digit[0];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		expression = null;
		Scanner scan = new Scanner(System.in);
		expression = scan.nextLine();
		while(!expression.equals("0")){
			exp=new char[expression.length()];
			int i,j;
			j=0;
			index=0;
			/*
			 * change String to array of char
			 */
			for(i=0;i<expression.length();i++){
				if(' '!=expression.charAt(i)){
					exp[j]=expression.charAt(i);
					j++;
				}
			}
			len=j;
			System.out.println(calc());
			expression = scan.nextLine();
		}
		
		
	}
}//(1)+((1-2)*3)+(3+7)