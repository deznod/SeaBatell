package ru.dve;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;


/**
 * Класс панели игрового поля
 */

public class Field extends JPanel {
    private Timer tmDraw;// Таймер отрисовки
    private Image fon, paluba, ubit, ranen, end1, end2, bomba;// Изображения, используемые в игре
    private JButton btn1, btn2;// Две кнопки
    private game myGame;// Переменная для реализации логики игры


    /**
     * Конструктор класса
     */
    public Field() {
        myGame = new game();// Создаем объект новой игры
        myGame.start();// Запускаем игру
        // Попытка загрузки всех изображений для игры
        try {
            fon = ImageIO.read(new File("F:\\SeaBatell\\src\\ru\\dve\\img\\fon.png"));
            paluba = ImageIO.read(new File("F:\\SeaBatell\\src\\ru\\dve\\img\\paluba.png"));
            ranen = ImageIO.read(new File("F:\\SeaBatell\\src\\ru\\dve\\img\\ranen.png"));
            ubit = ImageIO.read(new File("F:\\SeaBatell\\src\\ru\\dve\\img\\ubit.png"));
            end1 = ImageIO.read(new File("F:\\SeaBatell\\src\\ru\\dve\\img\\end1.png"));
            end2 = ImageIO.read(new File("F:\\SeaBatell\\src\\ru\\dve\\img\\end2.png"));
            bomba = ImageIO.read(new File("F:\\SeaBatell\\src\\ru\\dve\\img\\bomba.png"));
        } catch (Exception ex) {
        }
        //Создаем, настраиваем и запускаем таймер для отрисовки игрового поля
        tmDraw = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                repaint();
            }
        });
        tmDraw.start();
//Включаем возможность произвольного размещения элементов интерфейса на панели
        setLayout(null);
//Создаем кнопку Новая игра
        btn1 = new JButton();
        btn1.setText("Новая игра");
        btn1.setForeground(Color.BLUE);
        btn1.setFont(new Font("serif", 0, 30));
        btn1.setBounds(130, 450, 200, 80);
        btn1.addActionListener( new ActionListener() {
// Обработчик события при нажатии на кнопку Новая игра
            public void actionPerformed(ActionEvent arg0) {
// Запуск -начало игры
                myGame.start();
            }
        });
        add(btn1);
//Создаем кнопку Выход
        btn2 = new JButton();
        btn2.setText("Выход");
        btn2.setForeground(Color.RED);
        btn2.setFont(new Font("serif", 0, 30));
        btn2.setBounds(530, 450, 200, 80);
        btn2.addActionListener(new ActionListener() {
// Обработчик события при нажатии на кнопку Новая игра
            public void actionPerformed(ActionEvent arg0) {
// Выход их игры -завершение работы приложения
                System.exit(0);
            }
        });
        add(btn2);
    }
// Метод отрисовки
    public void paintComponent(Graphics gr)
    {
//Очищение игрового поля
        super.paintComponent(gr);
//Отрисовка фона
        gr.drawImage(fon, 0, 0, 900, 600, null);
//Установка шрифта
        gr.setFont(new Font("serif", 3, 40));
//Установка цвета
        gr.setColor(Color.BLUE);
//Выведение надписей
        gr.drawString("Компьютер", 150, 50);
        gr.drawString("Игрок", 590, 50);
//Отрисовка игрового поля Игрока на основании массива
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
// Если это палуба корабля
                if ((myGame.masPlay[i][j] >= 1) && (myGame.masPlay[i][j] <= 4)) {
                    gr.drawImage(paluba, 500 + j * 30, 100 + i * 30, 30, 30, null);
                }

            }

        }
//Отрисовка сетки игрового поля из синих линий
        gr.setColor(Color.BLUE);
        for (int i = 0; i <= 10; i++)
        {
// Рисование линий сетки игрового поля Компьютера
            gr.drawLine(100 + i * 30, 100, 100 + i * 30, 400);
            gr.drawLine(100, 100 + i * 30, 400, 100 + i * 30);
// Рисование линий сетки игрового поля Человека
            gr.drawLine(500 + i * 30, 100, 500 + i * 30, 400);
            gr.drawLine(500, 100 + i * 30, 800, 100 + i * 30);
        }
//Установка шрифта
        gr.setFont(new Font("serif", 0, 20));
//Установка цвета
        gr.setColor(Color.RED);
//Введение цифр и букв слева и сверху от игровых полей
        for (int i = 1; i <= 10; i++)
        {
// Вывод цифр
            gr.drawString("" + i, 73, 93 + i * 30);
            gr.drawString("" + i, 473, 93 + i * 30);
// Вывод букв
            gr.drawString("" + (char) ('A' + i - 1), 78 + i * 30, 93);
            gr.drawString("" + (char) ('A' + i - 1), 478 + i * 30, 93);

        }

    }

}