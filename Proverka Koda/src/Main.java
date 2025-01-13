public class Main
{
    public class MiddleChars
    {

        public static String getMiddleChars(String str)
        {
            if (str.length() % 2 != 0)
            {
                throw new IllegalArgumentException("String length must be even.");
            }

            int middleIndex = str.length() / 2;
            return str.substring(middleIndex - 1, middleIndex + 1);
        }

        public static void main(String[] args)
        {
            String str1 = "string";
            String str2 = "code";
            String str3 = "Practice";

            System.out.println("Middle characters of " + str1 + ": " + getMiddleChars(str1));
            System.out.println("Middle characters of " + str2 + ": " + getMiddleChars(str2));
            System.out.println("Middle characters of " + str3 + ": " + getMiddleChars(str3));
        }

    }
}
}