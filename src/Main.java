import java.util.*;

/*
Общие ссылки
https://javarush.com/groups/posts/3243-razbor-voprosov-i-otvetov-na-sobesedovanii-chastjh-1
Разбор вопросов и ответов с собеседований на Java-разработчика.
*/

public class Main {

    public static class Cat {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return Double.compare(weight, cat.weight) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight);
        }

        private int weight;

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Hello world!");
//****************** Примитивные переменные и Ссылочные переменные *********************************************************************************************************************************************************
        //https://skillbox.ru/media/base/tipy-dannykh-v-java/
        //Типы данных в Java: какие бывают, чем различаются и что такое ссылки и примитивы
        //Примитивные переменные - Хранят значение
        int a = 5;
        System.out.println("a="+a);
        //Ссылочные переменные - Хранят адрес объекта в памяти, на который ссылаются (отсюда и название).
        //Используются для доступа к объектам (его нельзя получить, если на объект нет ссылки)
        //К примеру для cat мы переписали equals
        Cat cat = new Cat();
        cat.setWeight(15);
        System.out.println("cat.getWeight"+cat.getWeight());
        Cat cat2 = new Cat();
        //cat2 = cat;
        System.out.println("cat.equals(cat2)="+cat.equals(cat2));
        //https://tproger.ru/articles/equals-hashcode-java
        // Чем отличаются ==, equals и hashCode?

//********* Методы equals() и hashcode() в языке Java ******************************************************************************************************************************************************************
        //https://tproger.ru/articles/equals-hashcode-java
        /* Используя equals, мы должны придерживаться основных правил, определённых в спецификации Java:
                1. Рефлексивность — x.equals(x) возвращает true.
                2. Симметричность — x.equals(y) <=> y.equals(x).
                3. Транзитивность — x.equals(y) <=> y.equals(z) <=> x.equals(z).
                4. Согласованность — повторный вызов x.equals(y) должен возвращать значение предыдущего вызова, если сравниваемые поля не изменялись.
        Сравнение null — x.equals(null) возвращает false. */
        Cat x = new Cat();
        x.setWeight(15);
        Cat y = new Cat();
        y.setWeight(15);
        Cat z = new Cat();
        z.setWeight(15);
        System.out.println("1. Рефлексивность x.equals(x)="+x.equals(x));
        System.out.println("2. Симметричность x.equals(y)="+x.equals(y)+" <=> y.equals(x)="+y.equals(x));
        System.out.println("3. Транзитивность x.equals(y)="+x.equals(y)+" <=> y.equals(z)="+y.equals(z)+" <=> x.equals(z)="+x.equals(z));
        System.out.println("4. Согласованность x.equals(y)="+x.equals(y));

//***************************************************************************************************************************************************************************
        // Хеш-таблица — Самая Популярная Структура Данных
        // https://www.youtube.com/watch?v=rPp46idEvnM&t=632s

        //https://github.com/topics/java-game
        //Примеры игры https://github.com/arminkz/PlantsVsZombies.git

        //Топ-50 Java Core вопросов и ответов на собеседовании
        //https://javarush.com/groups/posts/2590-top-50-java-core-voprosov-i-otvetov-na-sobesedovanii-chastjh-1
        /* ArrayList: Самая распространенная коллекция. По сути, это массив с динамически расширяемым размером. Работа по управлению размером массива лежит на коллекции.
            Особенности:
                быстрый перебор и быстрый поиск по индексу;
                коллекция упорядочена по индексу, но не сортирована;
                реализует RandomAccess интерфейс;
                медленное добавление в середину списка.*/
        ArrayList names = new ArrayList<>();
        names.add("John");
        names.add("John");
        names.add("Roman");
        names.add("Ivan");
        //В выводе видно, что это повторяемые элементы. Они выведены в порядке, в котором их записали.
        System.out.println("ArrayList names = "+names);

        /*Linked List: Это коллекция, в которой каждый элемент имеет ссылку на предыдущий и следующий элементы. По этим ссылкам можно переходить от одного элемента к другому.
            При добавлении элемента просто меняются ссылки на предыдущий и следующий элементы:
                элементы связаны друг с другом, то есть реализован двусвязный список;
                общая скорость работы заметно ниже, чем в ArrayList;
                отличный выбор для большого количества вставок и удалений в середину массива;
                реализует интерфейсы списков Queue и Deque, поэтому и имеет их методы для работы.*/
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");
        System.out.println("linkedList = "+linkedList);

        /*HashMap:
            не отсортирован и не упорядочен;
            используют если не важны порядок и сортировка;
            поддерживает null ключ.*/
            HashMap positions = new HashMap<>();
            positions.put("junior", "Ivan");
            positions.put("middle", "Roman");
            positions.put("senior", "Vasily");
            positions.put("team lead", "Anton");
            positions.put("arthitect", "Andrew");
            positions.put("senior", "John");
            positions.put(123, "John");
            //Ключи всегда уникальны, поэтому записан только один senior
            System.out.println("HashMap positions = " + positions);

        /*LinkedHashMap:
            поддерживает порядок вставки;
            медленнее, чем HashMap;
            ожидается, что итерация быстрее, чем в HashMap.*/
        LinkedHashMap<String, String> positionsLHM = new LinkedHashMap<>();
        positionsLHM.put("junior", "Ivan");
        positionsLHM.put("middle", "Roman");
        positionsLHM.put("senior", "Vasily");
        positionsLHM.put("team lead", "Anton");
        positionsLHM.put("arthitect", "Andrew");
        positionsLHM.put("senior", "John");
        System.out.println("LinkedHashMap<String, String> positionsLHM = " + positionsLHM);

        /*TreeMap:
            Реализация мапы, которая сохраняет записи отсортированными в соответствии с естественным порядком их ключей или,
            что еще лучше, с использованием компаратора, если он предоставляется в конструкторе при создании мапы.*/
        //Без компаратора
        TreeMap<Integer, String> positionsTM = new TreeMap<>();
        positionsTM.put(1, "Ivan");
        positionsTM.put(3, "Roman");
        positionsTM.put(2, "Vasily");
        positionsTM.put(10, "Anton");
        positionsTM.put(7, "Andrew");
        positionsTM.put(1, "John");
        System.out.println("TreeMap<Integer, String> positionsTM = " + positionsTM);

        //используем реализацию Strategy Pattern'a и добавим компаратор:
        TreeMap<Integer, String> positionsTMC = new TreeMap<>(Comparator.reverseOrder());
        positionsTMC.put(1, "Ivan");
        positionsTMC.put(3, "Roman");
        positionsTMC.put(2, "Vasily");
        positionsTMC.put(10, "Anton");
        positionsTMC.put(7, "Andrew");
        positionsTMC.put(1, "John");
        //Видим, что стандартно реализована сортировка в порядке возрастания, но это можно изменить, добавив компаратор в конструктор.
        System.out.println("TreeMap<Integer, String> positionsTMC = " + positionsTMC);

        //Расскажите о коллекции Set и ее реализациях?
        //Set — это множество уникальных элементов, и это ее главная особенность. То есть Set не допускает повторения одних и тех же элементов.
        //Здесь важно, чтобы у объектов, которые добавляются, был реализован метод equals.

        /*HashSet:
            не отсортирован и не упорядочен. Под капотом там HashMap с заглушкой для значения. Посмотрите сами ;)
            использует hashCode для добавления объектов;
            стоит использовать, когда нужно иметь уникальные объекты и их порядок не важен.*/
        HashSet<String> positionsHS = new HashSet<>();
        positionsHS.add("junior");
        positionsHS.add("junior");
        positionsHS.add("middle");
        positionsHS.add("senior");
        positionsHS.add("team lead");
        positionsHS.add("architect");
        //Здесь видно, что элемент “junior”, который дважды добавлен, присутствует только в единичном экземпляре. И порядок не такой же, как при добавлении.
        System.out.println("HashSet<String> positionsHS = " + positionsHS);

        /*LinkedHashSet:
            упорядоченная версия HashSet;
            поддерживает двусвязный список для всех элементов;
            использовать его, когда требуется упорядоченность при итерации.*/
        LinkedHashSet<String> positionsLHS = new LinkedHashSet<>();
        positionsLHS.add("junior");
        positionsLHS.add("junior");
        positionsLHS.add("middle");
        positionsLHS.add("senior");
        positionsLHS.add("team lead");
        positionsLHS.add("architect");
        System.out.println("LinkedHashSet<String> positionsLHS = " + positionsLHS);

        /*TreeSet:
            одна из двух сортированных коллекций;
            использует структуру красно-черного дерева и гарантирует, что элементы будут в возрастающем порядке;
            под капотом это TreeMap с заглушкой на значениях. А элементами TreeSet являются ключи к TreeMap (также посмотрите ;)).*/
        TreeSet<String> positionsTS = new TreeSet<>();
        positionsTS.add("junior");
        positionsTS.add("junior");
        positionsTS.add("middle");
        positionsTS.add("senior");
        positionsTS.add("team lead");
        positionsTS.add("architect");
        System.out.println("TreeSet<String> positionsTS = " + positionsTS);

        /* 31. Что такое Exception
           Exception — это проблема, которая может возникнуть в runtime. Это исключительная ситуация, которая возникает из-за каких-то причин.
Диаграмма наследования исключений выглядит так (нужно знать ее назубок ;) ):
                                  ---------------------------------------------
                                  |          Throwable                        |
                                  ---------------------------------------------
                                  |     Error    |     Exception              |
                                  ---------------------------------------------
                                  |              | Others | Runtime Exception |
                                  ---------------------------------------------
Топ-50 Java Core вопросов и ответов на собеседовании. Часть 2 - 3На диаграмме видно, что в целом все исключения делятся на две группы — exceptions и error.
Error — используются JVM для отображения ошибок, после которых работа приложения уже не имеет смысла. Например StackOverFlowError, которая говорит, что стек заполнен и программа уже не может работать.
Exception — исключения, которые генерируются программно в коде. Есть разные исключения, проверяемые и непроверяемые, но главное, что они есть, и их можно перехватить и продолжить работу приложения.
Exceptions, в свою очередь, еще делятся на тех, кто наследуется от RuntimeException и других наследников Exception.
В рамках этого вопроса информации достаточно. О том, что такое проверяемые / непроверяемые исключения, поговорим ниже. */

        /**
         * Пример, в котором показываются две опции — когда находится обработчик для исключения и когда нет.
         */
        /*ThrowerExceptionExample example = new ThrowerExceptionExample();
        System.out.println("151 example.populateString()) = "+example.populateString());*/

        /* Checked и Unchecked исключения в Java
        B Java есть два типа исключений — checked и unchecked.
                Checked исключения:
        Это исключения, которые проверяются во время компиляции. Если какой-то код в методе во время исключения выдает checked исключение, метод обязан либо обработать его при помощи try-catch, либо пробросить его дальше
        На примере, который считывает картинку из пути "/users/romankh3/image.png", обновляет ее каким-то образом(для нас это не важно) и сохраняет ее обратно. */

    }
}