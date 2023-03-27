package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Catalog> catalogs = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        while (true) {

            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {

                case 1:
                    inputCatalogs(catalogs,scanner);
                    break;
                case 2:
                    inputProducts(products,scanner,catalogs);

                    break;
                case 3:
                    sortProductsByExportPrice(products);
                    break;
                case 4:
                    searchProductsByCatalogName(products,scanner);
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        }
    }

    private static void inputCatalogs(List<Catalog> catalogs,Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the new line
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin danh mục sản phẩm thứ " + (i + 1) + ":");
            Catalog catalog = new Catalog();
            catalog.inputData(catalogs,scanner);
            catalogs.add(catalog);
        }
        System.out.println("Nhập thông tin danh mục sản phẩm thành công!");
    }

    private static void inputProducts(List<Product> list,Scanner scanner,List<Catalog> listCata) {
        List<Catalog> catalogs = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        System.out.print("Nhập số sản phẩm: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the new line
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            Product product = new Product();
            product.inputData(listCata,scanner);
            System.out.println("Danh sách các danh mục sản phẩm đang quản lý:");
            displayCatalogs();
            System.out.print("Chọn mã danh mục sản phẩm cho sản phẩm (1-" + catalogs.size() + "): ");
            int catalogId = scanner.nextInt();
            scanner.nextLine(); // consume the new line
            Catalog selectedCatalog = getCatalogById(catalogId);
            product.setCatalog(selectedCatalog);
            System.out.println(products.add(product));
            ;
        }
        System.out.println("Nhập thông tin sản phẩm thành công!");
    }
    private static void displayCatalogs() {
        List<Catalog> catalogs = new ArrayList<>();
        System.out.printf("%-10s%-20s%-20s%-20s\n", "  Mã danh mục", "Tên danh mục", "Độ ưu tiên", "Trạng thái");
        for (Catalog catalog : catalogs) {
            catalog.displayData();
        }
    }
    public static void searchProductsByCatalogName(List<Product> list,Scanner scanner) {

        List<Product> listSearch = new ArrayList<>();
        System.out.println("Nhâp tên danh mục của sản phẩm cần tìm");
        String searchCatalog = scanner.nextLine();
        for(Product product:list) {
            if (product.getCatalog().getCatalogName().contains(searchCatalog)) {
                listSearch.add(product);
            }
        }
        displayProducts(listSearch);
    }
    public static void displayProducts(List<Product> list) {
        for (Product product : list) {
            product.displayData();
        }
    }

    public static Catalog getCatalogById(int id) {
        List<Catalog> catalogs = new ArrayList<>();
        for (Catalog catalog : catalogs) {
            if (catalog.getCatalogId() == id) {
                return catalog;
            }
        }
        return null;
    }

    public static void sortProductsByExportPrice(List<Product> list) {
        List<Product> sortList = new ArrayList<>(list);
        Collections.sort(sortList);
        displayProducts(sortList);
    }
}

