package notes;
import java.util.*;
import java.io.*;
public class Notes_application
{
	String name;
	String content;
	
    public static  int count=0;
    ArrayList<Notes_application> nlist = new ArrayList<>();
	
	Notes_application(String na,String text)
	{
		name=na;
		content=text;
		
    	try 
    	{
            File Obj = new File("C:\\Users\\ELCOT\\eclipse-workspace\\notes\\files\\",name);
            
            if (Obj.createNewFile()) 
            {
                System.out.println("\nFile created: " + Obj.getName());
                
                String str1,str2,str3;
        		str1 = "C:\\Users\\ELCOT\\eclipse-workspace\\notes\\files\\";
        		str2 = name;
        		str3 = str1.concat(str2);
        	    try
        	    {
        	    FileOutputStream fos = new FileOutputStream(str3,true);
        	    PrintWriter pw = new PrintWriter(fos);
        	    char ch;
        	    pw.print(content);
        	 
        	    ch=' ';
        	    pw.print(ch);
        	    pw.close();
        	   
        	    System.out.println("\nwritten to the file successfully");
        	    }
        	    catch (IOException e )
        		{
                    System.out.println("An error has occurred");
                    
                }

             }
            else
            {
            	int i;
            	Notes_application a;
            	for(i=0;i<count;i++)
                {
                 a= nlist.get(i);
            	if(a.name.equals(name))
             	{
                    nlist.remove(a);
                    count=count-1;
             	}
                }
               System.out.println("\nNote already exits");        
    	    }                       
         
    	}
        catch (IOException e) 
    	{
            System.out.println("An error has occurred");
         
        }
	}
	
	
     void displaynotename()
    { 
    	System.out.println(name);
    }
    	    
	
	void displaynote()
	{		
	    System.out.println(content);	
	}
	
	Notes_application()
	{
		
	}
	
    
	
    public void cnote() 
    {
    	System.out.println("\n\nEnter the note name: ");
    	Scanner scan = new Scanner(System.in);
    	String name = scan.nextLine();
    	
    	
    	int j=0;
	    char arr[][]=new char [100][100];
    	count = count+1;
        		
        	    try
        	    {	
        	     
        	    System.out.println("\nEnter the text that you want to add :\n");
        	    DataInputStream d = new DataInputStream(System.in);
        	    char ch;
        	    while((ch = (char)d.read())!='`')
        	    {
        	    	arr[count][j]=ch;
        	    	j=j+1;
        	    }
        	    }
        	   
        	    catch (IOException e )
        		{
                    System.out.println("An error has occurred");
                    
                }

             
     String content = String.copyValueOf(arr[count]);
                     
     Notes_application  newcnote = new Notes_application(name,content);
        nlist.add(newcnote);
    }
    
  
    public void lnote()
    {
      int i;
      Notes_application a;
  
      System.out.println("\n\nThe list of notes are: \n");
     for(i=0;i<count;i++)
     {
    	a= nlist.get(i);
    	//System.out.println(a);
        a.displaynotename();
    	 
     }
    }
    
    
    public void vnote()
    {
    	int i;
    	Notes_application a;
    	System.out.println("\n\nThe list of notes are: \n");
    	for(i=0;i<count;i++)
        {
       	 nlist.get(i).displaynotename();
       	 
        }
    	System.out.println("\n\nEnter the note name that you want to view: ");
    	Scanner scan = new Scanner(System.in);
    	String nname = scan.nextLine();
    	System.out.println("\n\nThe content of the note are: \n");
    	
     //   pos=namel.indexOf(nname);
     //   System.out.println(pos);
     //   nlist.get(pos).displaynote();
    	
    	 for(i=0;i<count;i++)
         {
        	a= nlist.get(i);
        	if(a.name.equals(nname))
        	{
               a.displaynote();
        	}
         }
    	
    	
    }
    
    
    public void dnote()
    {
    	int i;
    	Notes_application a;
    	System.out.println("\n\nThe list of notes are: \n");
    	
    	for(i=0;i<count;i++)
        {
       	 nlist.get(i).displaynotename();
        }
    	
    	System.out.println("\n\nEnter the note name that you want to delete: ");
    	Scanner scan = new Scanner(System.in);
    	String nname = scan.nextLine();
    	
//    	pos=namel.indexOf(nname);
//    	nlist.remove(pos);
    	
         for(i=0;i<count;i++)
         {
        	 a= nlist.get(i);
         	if(a.name.equals(nname))
         	{
                nlist.remove(a);
                count=count-1;
                System.out.println("\n\nThe note is deleted sucessfully");
         	}
        	  
         }	
         
         
         System.out.println("\n\nThe lists of notes are: \n");
         for(i=0;i<count;i++)
         {
        	 nlist.get(i).displaynotename();
        	 
         }
    }
    

	public void notesapp()
	{
		int n;
		System.out.println("\n**Notes**");
		System.out.println("\n1.create note\n2.list note\n3.view note\n4.delete note\n5.close app");
		Scanner scan = new Scanner(System.in);
		System.out.print("\nchoose any one option: ");
		n = 7;
		try
		{
		n = scan.nextInt();
		}
		catch ( java.util.InputMismatchException e) 
		{
	     System.out.println("\nplease enter the valid option :");
	     notesapp();
	    }
	       
		switch(n)
		{
		 case 1:cnote();
		        notesapp();

	     case 2: lnote();
	            notesapp();
	     
	     case 3:vnote();
	            notesapp();
	     
	     case 4:dnote();
	            notesapp();
	     
	     case 5: System.out.println("\nBye..");
	    	 System.exit(0);
	    
	     default: System.out.println("\nEnter the valid option :");
	             notesapp();
	              
		}
	}
	
	
	
	public static void main(String[] args)
	{
		 
		Notes_application n = new Notes_application();
			n.notesapp();
	}	
}




