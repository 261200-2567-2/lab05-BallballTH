import java.util.Scanner;

public class ScannerInput {

    public String getLineInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int intInput(){
        String input = getLineInput();
        try{
            return Integer.parseInt(input);

        }catch(NumberFormatException e) {
            System.out.print("Please enter an integer : ");
            return intInput();
        }
    }

    public long longInput(){
        String input = getLineInput();
        try{
            return Long.parseLong(input);

        }catch(NumberFormatException e) {
            System.out.print("Please enter an integer : ");
            return longInput();
        }
    }

    public String strLine(){
        return getLineInput();
    }

}
