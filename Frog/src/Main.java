
///////////////////////////////////////ТРЕТЬЯ ЛАБА///////////////////////////////////////////////////
import java.io.PrintStream; // Что-то для русского языка в библиотеках
import java.io.UnsupportedEncodingException; // Что-то для русского языка в библиотеках
class HighArray
{
    private long a[];
    private int n;
    private int nElems;

    public HighArray(int max)
    {
        a = new long[max];
        n = 0;
    }

    public void BubbleSort() // Сортировка пузырьком
    {
        for (int i = 0; i < nElems - 1; i++)
        {
            for(int j = 0; j < nElems - i - 1; j++)
            {
                if(a[j + 1] < a[j])
                {
                    long swap = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = swap;
                }
            }
        }
    }

    public void SelectionSort() // Сортировка выбором
    {
        for (int i = 0; i < nElems; i++)
        {
            int pos = i;
            long min = a[i];
            for (int j = i + 1; j < nElems; j++)  // выбор наименьшего элемента
            {
                if (a[j] < min)
                {
                    pos = j; // pos - индекс наименьшего элемента
                    min = a[j];
                }
            }
            a[pos] = a[i];
            a[i] = min; // меняем местами наименьший с а[i]
        }
    }

    public void InsertionSort() // Сортировка вставкой
    {
        int j;
        for (int i = 1; i < nElems; i++)
        { //сохраняем ссылку на индекс предыдущего элемента
            long swap = a[i];
            for (j = i; j > 0 && swap < a[j - 1]; j--)
            { //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                a[j] = a[j - 1];
            }
            a[j] = swap;
        }
    }

    public boolean find(long searchKey) // Обычный поиск
    { //поиск заданного значения
        int j;
        for(j=0; j<nElems; j++) //для каждого элемента
            if (a[j]==searchKey) //значение найдено?
                break;//да-выход из цикла
        if (a[j]>searchKey) // кчвсаемнпиваряаяраввввввв н н65н р // Не нашли, что надо, а значения уже больше искомого?
            return false;   // утеыьепаьачаиииииииииииииитвпппппи // Ghtrhfoftv - lfkmit ghjdthznm cvsckf ytm
        if(j==nElems) //достигнут последний элемент?
            return false; //да
        else
            return true; //нет

    }

    public boolean doublefind(long searchKey) // Двоичный(бинарный) поиск
    {

        int frog = 0; //первый
        int froggy = n - 1; //последний
        while(frog <= froggy)
        {
            int forg = (frog + froggy) / 2; //средний
            if (a[forg] == searchKey)
            {
                return true; //нашли
            }
            else if (a[forg] < searchKey)
                frog = forg + 1; //отбрасываем левую часть
            else if (a[forg] > searchKey)
                froggy = forg - 1; //отбрасываем правую часть
        }
        return false;
    }

    public void sortirovka(long value) // Обычная сортировка
    {
        int i = n - 1; //индекс конечного элемента массива
        while (i >= 0 && a[i] > value)
        { //пока мы не прошли весь массив и элемент с тем индексом i больше вставляемого
            a[i + 1] = a[i]; //сдвигаем элементы влево
            i--;
        }
        a[i + 1] = value;
        n++;
    }

    public boolean delete(long value) // Что-то удаляется (из первоначального кода)
    {
        int j;
        for (j = 0; j < n; j++)
            if (value == a[j])
                break;
        if (j == n)
            return false;
        else {
            for (int k = j; k < n; k++)
                a[k] = a[k + 1];
            n--;
            return true;
        }
    }

    public void display()
    {
        for (int j = 0; j < n; j++)
            System.out.print(a[j] + " ");
        System.out.println(" ");
    }
}

class HighArrayApp
{
    public static void main(String[] args) //Что-то для русского языка
    {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);
        arr.sortirovka(77);
        arr.sortirovka(99);
        arr.sortirovka(44);
        arr.sortirovka(55);
        arr.sortirovka(22);
        arr.sortirovka(88);
        arr.sortirovka(11);
        arr.sortirovka(00);
        arr.sortirovka(66);
        arr.sortirovka(33);
        long s = 40;
        if(arr.doublefind(s))
            System.out.println("Найдено " + s);
        else System.out.println("Не найдено " + s);
        arr.display();



        System.out.println("Сортировка пузырьком: ");
        arr.BubbleSort(); // Вывод на экран сортировки пузырьком
        arr.display();

        System.out.println("Сортировка вставками: ");
        arr.InsertionSort(); // Вывод на экран сортировки вставками
        arr.display();

        System.out.println("Сортировка выбором: ");
        arr.SelectionSort(); // Вывод на экран сортировки выбором
        arr.display();
    }
}

//в шестой поиск элемента и удаление элемента ( по ключу)
