import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WhitePages {
    public static void main(String [] args) throws IOException {
        Scanner Sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF8"));
        FileWriter fw = new FileWriter("WhitePages.txt", true);
        FileReader fr = new FileReader("WhitePages.txt");
        int flagExit=0;
        System.out.println("Welcome to White Pages !!!");
        while(flagExit!=1){
         System.out.println("If you will add new person input 1");
         System.out.println("If you will get all list input 2");
         System.out.println("If you will search person input 3");
         System.out.println("If you will quit White Pages input 4");
         int choice =Sc.nextInt();
          switch(choice){
            case 1:
            {
                System.out.println("Input person's name to add in White Pages\n");
                String myStr= br.readLine();
                writeData(myStr,fw);

                System.out.println("Input person's surname to add in White Pages\n");
                myStr= br.readLine();
                writeData(myStr,fw);


                System.out.println("Input person's birthday to add in White Pages\n");
                myStr= br.readLine();
                writeData(myStr,fw);


                System.out.println("Input person's nickname to add in White Pages\n");
                myStr= br.readLine();
                writeData(myStr,fw);

                System.out.println("Input person's telephone number's to add in White Pages\n");
                myStr= br.readLine();
                writeData(myStr,fw);

                System.out.println("Input person's email's to add in White Pages\n");
                myStr= br.readLine();
                writeData(myStr,fw);

                fw.close();
                break;
            }
            case 2:
            {
                Path path = Paths.get("WhitePages.txt");
                List<String> miList= Files.readAllLines(path, StandardCharsets.UTF_8);
                ArrayList allList=new ArrayList(miList);
                if(allList.size()>0) {
                    System.out.println("White Pages's size is=" + allList.size());
                    System.out.println("All persons in White Pages :\n" + allList);
                }
                else{
                    System.out.println("White Pages is empty !!!");
                    System.out.println("Input new persons please!");
                }
                break;
            }
            case 3:
            {
                Path path = Paths.get("WhitePages.txt");
                List<String> miList1= Files.readAllLines(path, StandardCharsets.UTF_8);
                ArrayList allList1=new ArrayList(miList1);
                System.out.println("Input person's name or telephone to search him in White Pages\n");
                String myStr= br.readLine();
                if(Character.isDigit(myStr.charAt(0))||(myStr.charAt(0)=='+')){
                    if(allList1.contains(myStr)){
                        int ie = allList1.indexOf(myStr);
                        for(int i=ie-4;i<=ie+1;i++) System.out.println(allList1.get(i));
                    }
                    else{
                        System.out.println("This telephone not present in White Pages\n");
                    }
                }
                else{
                    if(allList1.contains(myStr)){
                        int ie = allList1.indexOf(myStr);
                        for(int i=ie;i<=ie+5;i++) System.out.println(allList1.get(i));
                    }
                    else{
                        System.out.println("This name\t"+"\""+myStr + "\""+"\tnot present in White Pages\n");
                    }
                }
                break;
            }
            case 4:
            {
                flagExit=1;
                break;
            }
        }
      }
   }

  public static void writeData(String wrtStr, FileWriter fw) throws IOException {
      for (int i = 0; i < wrtStr.length(); i++) {
          fw.write(wrtStr.charAt(i));
      }
      fw.write("\n");
  }


}
