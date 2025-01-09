public class Password 
{
    private String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String lower = "abcdefghijklmnopqrstuvwxyz";
    private String symbols = "!@#$%^&*";
    private int minLength, maxLength;
    
    public Password(int min, int max)
    {
        minLength = min;
        maxLength = max;
    }

    public boolean isValid(String password)
    {
        int validChecksPassed = 0;

        if(password.length() > minLength && password.length() < maxLength)
            validChecksPassed++;

        for(int i =0;i <upper.length();i++)
        {
            if(password.indexOf(upper.charAt(i)) != -1) {validChecksPassed++; break;}
        }

        for(int i =0;i <lower.length();i++)
        {
            if(password.indexOf(lower.charAt(i)) != -1) {validChecksPassed++; break;}
        }

        for(int i =0;i <symbols.length();i++)
        {
            if(password.indexOf(symbols.charAt(i)) != -1) {validChecksPassed++; break;}
        }

        if(validChecksPassed == 4) return true;

        return false;
    }
    
    
    public static void main(String[] args) {

        Password pass = new Password(1,40);
        System.out.println(pass.isValid("StringyString!!!"));
        System.out.println(pass.isValid("Thisisnotavalidpasswordbecauseitiswaaaaaytoolong"));
    }
}
