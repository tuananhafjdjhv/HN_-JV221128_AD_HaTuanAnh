package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        while (true) {
            System.out.println("***************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    scanner.nextLine();
                    System.out.print("Nhập câu của bạn: ");
                    String sentence = scanner.nextLine();
                    String[] words = sentence.split(" ");
                    for (String word : words) {
                        stack.push(word);
                    }
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Bạn chưa nhập câu!");
                        break;
                    }
                    System.out.print("Câu đảo ngược: ");
                    while (!stack.empty()) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Không hợp lệ. Vui lòng chọn 1, 2 hoặc 3.");
                    break;
            }
        }
    }
}
