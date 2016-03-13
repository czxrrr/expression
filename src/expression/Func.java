package expression;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Func {
	//var sayHi 	= new Function("sName", "sMessage", "alert(\"Hello \" + sName + sMessage);");
	//var doAdd = new Function("iNum", "alert(iNum + 10)");
	//怎么实现闭包。。在当前field 里面找变量，找不到就去上一级field里面找
	//
	public static String name;
	public ArrayList<Sentence> process;
	public Func parent;  //自己这里找不到变量，就去parent这个func 里面找，注意 最外层自动变成一个名为main 的Func

	public ArrayList<Variable> vars;
	public void execute(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bf;
		try {
			bf= new BufferedReader(new FileReader("file"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name.getClass();
		

	}

}
