import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class ExecuteShellComand {

    public static void main(String[] args) {

        ExecuteShellComand obj = new ExecuteShellComand();
        Scanner in = new Scanner(System.in);

            System.out.println("<Starting your application...>");
            System.out.print("$ ");

            String inputCommand = in.nextLine();
            System.out.println(inputCommand);

            //////////////////////// PWD Command//////////////////////////////////
//            if(inputCommand.equals("cd"))
//            {
//                System.out.print("\n \t PATH: /");
//                inputCommand =  "cmd.exe /c " + inputCommand;
//            }
//
//
//            String output = obj.executeCommand(inputCommand);
//            String outputs[] = output.split("\\\\");
//
//            System.out.println(outputs[outputs.length-1]);
            ////////////////////////////////////////////////////

    }

    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

}