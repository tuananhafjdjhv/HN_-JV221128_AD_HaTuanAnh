package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;
    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("– Mã danh mục sản phẩm: ");
        catalogId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("– Tên danh mục sản phẩm: ");
        catalogName = scanner.nextLine();
        System.out.print("– Độ ưu tiên: ");
        priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("– Mô tả danh mục: ");
        descriptions = scanner.nextLine();
        System.out.print("– Trạng thái danh mục (true/false): ");
        catalogStatus = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("mã danh mục: " + catalogId);
        System.out.println("à tên danh mục sản phẩm\n: " + catalogName);
    }
}
