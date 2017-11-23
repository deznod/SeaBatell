package ru.dve;
import java.awt.*;
import javax.swing.*;

/**
 * Класс окна игрового поля
 */
public class Window extends JFrame {

    public Window(){
        Field pan = new Field();//Создание объекта панели и подключения ее к окну
        Container cont = getContentPane();
        cont.add(pan);
        setTitle("Игра \"Морской бой\"");//Заголовок окна
        setBounds(0, 0, 900, 600);//Границы окна: расположение и размеры
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Операция при закрытии окна - завершение приложения
        setResizable(false);//Запрет изменения размеров окна
        setVisible(true);//Отображение (показ) окна

    }

}

