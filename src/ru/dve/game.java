package ru.dve;

// Класс реализации логики игры

public class game {
    // Массив для игрового поля игрока

    public int[][] masPlay;


// Конструктор класса


    public game() {

//Создаем массив 10x10 - игровое поле игрока

        masPlay = new int[10][10];

    }


// Запуск игры - начало игры

    public void start() {

//Очищаем игровое поле игрока

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                masPlay[i][j] = 0;

            }

        }
//Генерация однопалубных кораблей

// для игрового поля Игрока

        make1P(masPlay);
    }
    // Проверка невыхода за границы массива

    private boolean testMasPoz(int i, int j) {

        if (((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9))) {

            return true;

        } else

            return false;

    }
    // Запись значения в массив с проверкой границ массива

    private void setMasValue(int[][] mas, int i, int j, int val) {

// Если не происходит выход за границы массива
        if (testMasPoz(i, j) == true) {

// Записываем значение в массив

            mas[i][j] = val;

        }

    }
    // Установить один элемент окружения

    private void setOkr(int[][] mas, int i, int j, int val)

    {

// Если не происходит выход за пределы массива

// и в ячейке нулевое значение

        if (testMasPoz(i, j) && (mas[i][j] == 0))

// Устанавливаем необходимое значение

            setMasValue(mas, i, j, val);

    }
    //Окружение одной ячейки вокруг

    private void okrBegin(int[][] mas, int i, int j, int val) {

        setOkr(mas, i-1, j-1, val); // сверху слева

        setOkr(mas, i-1, j, val); // сверху

        setOkr(mas, i-1, j+1, val); // сверху справа

        setOkr(mas, i, j+1, val); // справа

        setOkr(mas, i+1, j+1, val); // снизу справа

        setOkr(mas, i+1, j, val); // снизу

        setOkr(mas, i+1, j-1, val); // снизу слева

        setOkr(mas, i, j-1, val); // слева

    }
    //Создание четырех однопалубных кораблей

    private void make1P(int[][] mas) {

// Цикл for делает четыре шага - для четырех кораблей

        for (int k = 1; k <= 4; k++) {

// Глухой цикл while

            while (true) {

// Находим случайную позицию на игровом поле

                int i = (int) (Math.random() * 10);

                int j = (int) (Math.random() * 10);

// Проверяем, что там ничего нет и можно разместить корабль



                if (mas[i][j] == 0) {

// Размещаем однопалубный корабль

                    mas[i][j] = 1;

// Выполняем окружение

                    okrBegin(mas, i, j, -1);

// Прерываем цикл

                    break;

                }
            }
        }
    }
}