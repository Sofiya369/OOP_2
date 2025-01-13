
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

    class StringOperations
    {

        // Метод для проверки делимости на 4 и неделимости на 6
        public static boolean isDivisibleBy4Not6(int number)
        {
            return number % 4 == 0 && number % 6 != 0;
        }

        // Метод для вычисления суммы цифр числа
        public static int sum(int number)
        {
            int sum = 0;
            while (number > 0)
            {
                sum += number % 10; //сумма не больще 10
                number /= 10;
            }
            return sum;
        }

        // Метод для возврата двух средних символов строки
        public static String getMiddle(String str)
        {
            if (str.length() % 2 == 0)
            { //длина строки
                int middleIndex = str.length() / 2; //средний индекс
                return str.substring(middleIndex - 1, middleIndex + 1); //два средних символа
            }
            else
            {
                return "";
            }
        }

        // Метод для поиска слова с минимальным числом различных символов
        public static String minСhars(String sentence)
        {
            String[] words = sentence.split("\s+"); //разделяет предложения на слова
            String minWord = words[0]; //первое слово
            int minUniqueChars = getUniqueChars(words[0]); //количество уникальных символов

            for (int i = 1; i < words.length; i++)
            {
                int currentUniqueChars = getUniqueChars(words[i]); //подсчет уникальных символов в текущем слове
                if (currentUniqueChars < minUniqueChars)
                {
                    minWord = words[i];
                    minUniqueChars = currentUniqueChars;
                }
            }

            return minWord;
        }

        // Метод для подсчета количества различных символов в строке (для задания выше)
         private static int getUniqueChars(String word)
        {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : word.toCharArray())
            {
                uniqueChars.add(c); //добавление символа в множество
            }
            return uniqueChars.size(); //возвращает символы
        }


        // Метод для подсчета слов, содержащих только символы латинского алфавита
        public static int LatinWords(String sentence)
        {
            String[] words = sentence.split("\s+");
            int count = 0;

            for (String word : words)
            {
                if (word.matches("[a-zA-Z]+"))
                { //проверка на то, состоит ли слово только из латинских букв
                    count++;
                }
            }
            return count;
        }
    }

    class Main
    {

        public static void main(String[] args)
        {

            // Установка кодировки консоли в UTF-8 (русский язык)
            try
            {
                System.setOut(new PrintStream(System.out, true, "UTF-8"));
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }

            // a) Вывести числа от 0 до 300, которые делятся на 4, но не делятся на 6 и
            // сумма цифр которых < 10.
            System.out.println("Числа, которые делятся на 4, но не делятся на 6 и сумма цифр которых < 10:");
            for (int i = 0; i <= 300; i++)
            {
                if (StringOperations.isDivisibleBy4Not6(i) && StringOperations.sum(i) < 10)
                {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            // b) Даны строки разной длины (длина — четное число), необходимо вернуть ее
            // два средних знака.
            String str1 = "string";
            String str2 = "code";
            String str3 = "Practice";
            System.out.println("Средние символы строки \"" + str1 + "\": " + StringOperations.getMiddle(str1));
            System.out.println("Средние символы строки \"" + str2 + "\": " + StringOperations.getMiddle(str2));
            System.out.println("Средние символы строки \"" + str3 + "\": " + StringOperations.getMiddle(str3));


            // c) Найти слово, в котором число различных символов минимально.
            String sentence = "fffff ab f 1234 jkjk";
            System.out.println("Слово с минимальным числом различных символов: " + StringOperations.minСhars(sentence));

            // d) Предложение состоит из нескольких слов, разделенных пробелами.
            // Например: "One two three раз два три one1 two2 123 ". Найти количество
            // слов, содержащих только символы латинского алфавита.
            String sentence2 = "One two three раз два три one1 two2 123";
            System.out.println("Количество слов, содержащих только символы латинского алфавита: " + StringOperations.LatinWords(sentence2));
        }
    }
