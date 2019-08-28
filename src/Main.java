import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String [] firstInput;
        int result = 0, j = 1;
        String operator = "", doubleMinus;

        while(true)
        {
            firstInput = scanner.nextLine().trim().split("\\s+");
            if (firstInput[0].equals("/exit"))
            {
                System.out.println("Bye!");
                return;
            }
            else if (firstInput[0].equals("/help"))
            {
                System.out.println("The program calculates the sum of numbers");
                continue;
            }
            else if (firstInput[0].matches("/.*"))
            {
                System.out.println("Unknown command");
                continue;
            }
            try
            {
            if (firstInput[0].matches("\\D+") || (firstInput[0].matches("\\d+") && firstInput[1].matches("\\d+")) ||
                firstInput[0].matches("\\d+-") || firstInput[0].matches("\\d+\\+"))
            {
                System.out.println("Invalid expression");
                continue;
            }
            } catch(Exception e){};

            for (int i = 0; i < firstInput.length; i = i + 2)
            {
                try
                {
                doubleMinus = firstInput[j].replaceAll("--", "+");
                if (doubleMinus.matches("[+]*"))
                    operator = "+";
                else if (doubleMinus.matches("[+]?[-]+"))
                    operator = "-";
                }
                catch (Exception e) {};
                j = j + 2;

                if (i == 0 && firstInput[0].matches("^-?[0-9]\\d*(\\.\\d+)?$")) // if (result == 0 && firstInput[0].matches("\\d"))
                    result = Integer.parseInt(firstInput[0]);


                switch (operator)
                {
                    case "+":
                          try
                          {
                              result = result + Integer.parseInt(firstInput[i + 2]);
                          }
                          catch (Exception e) { }
                          break;
                    case "-": // sve radi osim oduzimanja
                          try
                          {
                              result = result - Integer.parseInt(firstInput[i + 2]);
                          }
                          catch (Exception e) { }
                }

            } // for
            if (firstInput[0].matches("\\+\\d+"))
            {
                String value = "";
                value = firstInput[0].replaceAll("\\+", "");
                System.out.println(value);
                continue;
            }
            if (!firstInput[0].equals("")) // (!firstInput[0].matches("[]*"))
                System.out.println(result);
            result = 0;
            j = 1;
        } // while



    }
}
