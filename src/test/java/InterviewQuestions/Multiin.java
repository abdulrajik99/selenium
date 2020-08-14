package InterviewQuestions;

public class Multiin extends Singleinh
{
  int a=20;
  void display()
  {
	  
	  System.out.println("subclass");
  }
  public static void main(String args[])
  {
	  Multiin ob=new Multiin();
	  ob.display();
	  System.out.println(ob.x);

  }
  
}
