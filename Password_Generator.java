import java.io.*;
import java.util.Random;

class Password_Generator
{
    public static int len;
    public static String password = "";

    public static char lowerCaseCharacters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static char upperCaseCharacters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static Random ran = new Random();

    public static void smallCase()
    {
        for(int i=1; i<=len; i++)
            password = password + lowerCaseCharacters[ran.nextInt(26)];
    }
    
    public static void upperCase()
    {
        for(int i=1; i<=len; i++)
            password = password + upperCaseCharacters[ran.nextInt(26)];
    }
    
    public static void smallUpperCase()
    {
        for(int i=1; i<=len; i++)
        {
            if(ran.nextInt(2) == 0)
                password = password + lowerCaseCharacters[ran.nextInt(26)];
            else
                password = password + upperCaseCharacters[ran.nextInt(26)];
        }
    }
    
    public static void alphaNumericSmallCase()
    {
        for(int i=1; i<=len; i++)
        {
            if(ran.nextInt(2) == 0)
                password = password + lowerCaseCharacters[ran.nextInt(26)];
            else
                password = password + ran.nextInt(10);
        }
    }
    
    public static void alphaNumericUpperCase()
    {
        for(int i=1; i<=len; i++)
        {
            if(ran.nextInt(2) == 0)
                password = password + upperCaseCharacters[ran.nextInt(26)];
            else
                password = password + ran.nextInt(10);
        }
    }
    
    public static void alphaNumeric()
    {
        for(int i=1; i<=len; i++)
        {
            if(ran.nextInt(3) == 0)
                password = password + lowerCaseCharacters[ran.nextInt(26)];
            else if(ran.nextInt(3) == 1)
                password = password + upperCaseCharacters[ran.nextInt(26)];
            else
                password = password + ran.nextInt(10);
        }
    }
    
    public static void alphaNumericSpecial(String specialch)
    {
        for(int i=1; i<=len; i++)
        {
            if(ran.nextInt(4) == 0)
                password = password + lowerCaseCharacters[ran.nextInt(26)];
            else if(ran.nextInt(4) == 1)
                password = password + upperCaseCharacters[ran.nextInt(26)];
            else if(ran.nextInt(4) == 2)
                password = password + ran.nextInt(10);
            else
                password = password + specialch.charAt(ran.nextInt(specialch.length()));
        }
    }
    
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the length of the password: ");
        len = Integer.parseInt(br.readLine());
        if(len < 1)
            System.out.println("Password length cannot be less than 1");
        else
        {
            System.out.println("Please select your required password type:");
            System.out.println("\t1. Smallcase\n\t2. Uppercase\n\t3. Smallcase + Uppercase\n\t4. Alphanumeric (Smallcase)\n\t5. Alphanumeric (Uppercase)\n\t6. Alphanumeric (Smallcase + Uppercase)\n\t7. Alphanumeric + Special Characters");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());
            switch(choice)
            {
                case 1:
                    smallCase();
                    break;

                case 2:
                    upperCase();
                    break;

                    case 3:
                    smallUpperCase();
                    break;

                case 4:
                    alphaNumericSmallCase();
                    break;

                case 5:
                    alphaNumericUpperCase();
                    break;

                case 6:
                    alphaNumeric();
                    break;

                case 7:
                    System.out.print("Enter the special characters (without space): ");
                    String specialch = br.readLine();
                    alphaNumericSpecial(specialch);
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    System.exit(0);
            }
            System.out.println("Required Password: " + password);
        }
    }   
}