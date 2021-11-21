package linkedlist;

//1) Добавление/удаление элемента в список (с клавиатуры);
//        2) Вывод исходного и результирующего списков на экран;
//        3) Если списки являются многочленами, в выводе должна быть
//        отражена степень каждого элемента
public interface List {

    Double addElement(Double value);

    List withReversedSigns();

    List withAbsValues();

    List sumReversedAndAbsValuesWithoutZeros();

    Double[] asArray();

}
