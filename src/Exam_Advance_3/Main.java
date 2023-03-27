package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();
        while (true) {
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.println("Hãy nhập lựa chọn");
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên phụ huynh: ");
                    String parentName = scanner.nextLine();
                    queue.add(parentName);
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Không có phụ huynh nào trong danh sách");
                    } else {
                        System.out.println("Phụ huynh đầu tiên trong danh sách: " + queue.peek());
                        queue.remove();
                    }
                    break;
                case 3:
                    System.out.println("Thoát khỏi chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng chọn 1, 2 hoặc 3.");
            }
        }
    }
}
