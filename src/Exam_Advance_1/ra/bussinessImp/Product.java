package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product implements IShop, Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
        super();
    }

    public Product(int productId, String productName, String title, String descriptions,
                   Catalog catalog, float importPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = importPrice * RATE;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(List<Catalog> list, Scanner scanner) {

        System.out.print("Enter product id: ");
        this.productId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.print("Tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();
        System.out.print("Mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Nhập giá nhâp: ");
        this.importPrice = scanner.nextFloat();
        scanner.nextLine();
        this.exportPrice = this.importPrice * RATE;

        System.out.println("Chọn danh mục cho sản phẩm: ");
        List<Catalog> categories = new ArrayList<>();
        System.out.println("Chọn mã danh mục sản phẩm");
        int id = Integer.parseInt(scanner.nextLine());
        for (Catalog catalog : categories) {
            if (catalog.getCatalogId() == id) {
                setCatalog(catalog);
                break;
            }
        }
        System.out.println("Nhập trạng thái sản phẩm");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
    }
    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Danh mục sản phẩm: " + this.catalog.getCatalogName());
        System.out.println("Giá bán: " + this.exportPrice);
        System.out.println("Trạng thái sản phẩm(true/false): " + (this.productStatus ? "Active" : "inActive"));
    }

    @Override
    public int compareTo(Product p) {
        return (int )(this.exportPrice- p.exportPrice);
    }
}

