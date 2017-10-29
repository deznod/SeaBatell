package ru.dve;
// Необходимые библиотеки

import java.awt.*;

import javax.swing.*;



//Класс окна игрового поля

public class okno extends JFrame

{

// Конструктор класса

    public okno()

    {

//Создание объекта панели и подключения ее к окну

        pole pan = new pole();

        Container cont = getContentPane();

        cont.add(pan);

//Заголовок окна

        setTitle("Игра \"Морской бой\"");

//Границы окна: расположение и размеры

        setBounds(0, 0, 900, 600);

//Операция при закрытии окна - завершение приложения

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Запрет изменения размеров окна

        setResizable(false);

//Отображение (показ) окна

        setVisible(true);

    }

}

