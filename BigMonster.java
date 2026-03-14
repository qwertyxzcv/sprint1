import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {
    private String image = "\uD83D\uDC79";
    private Random r = new Random();
    public BigMonster(int sizeBoard) {
        super(sizeBoard);
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");
        if (difficultGame == 1) {
            return taskMonster();
        }
        int length;
        int start;
        int step;
        if (difficultGame <= 3) {
            length = 4;
            start = r.nextInt(20) + 1;
            step  = r.nextInt(5) + 1;
        }
        else if (difficultGame <= 5) {
            length = 5;
            start = r.nextInt(30) + 1;
            step  = r.nextInt(7) + 1;  // 1–7
        }
        else {
            length = 5;
            start = r.nextInt(50) + 1;
            step  = r.nextInt(9) + 2;  // 2–10
        }
        if (r.nextInt(10) < 2) {
            step = -step;
        }
        int[] sequence = new int[length];
        int current = start;
        for (int i = 0; i < length; i++) {
            sequence[i] = current;
            current += step;
        }
        System.out.print("Какое следующее число в последовательности?\n");
        System.out.print("  ");
        for (int i = 0; i < length - 1; i++) {
            System.out.print(sequence[i]);
            if (i < length - 2) {
                System.out.print(", ");
            } else {
                System.out.print(" → ?");
            }
        }
        System.out.println();
        int correctAnswer = sequence[length - 1];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Твой ответ: ");

        int playerAnswer;
        try {
            playerAnswer = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Нужно ввести целое число!");
            return false;
        }
        if (playerAnswer == correctAnswer) {
            System.out.println("Верно! Ты победил монстра!");
            return true;
        } else {
            System.out.println("Неправильно, правильный ответ: " + correctAnswer);
            System.out.println("Ты проиграл эту битву!");
            return false;
        }
    }
    public boolean taskMonster() {
        return super.taskMonster(0);
    }
}
