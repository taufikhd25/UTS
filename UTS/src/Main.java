import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String description;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return 
                "Judul:" + title + '\n' +
                "Sinopsis:" + description + '\'' ;
    }
}

class BookManager {
    private ArrayList<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String description) {
        books.add(new Book(title, description));
        System.out.println("Buku Telah Terdaftar");
    }

    public ArrayList<Book> searchBooks(String keyword) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Tidak Ada Buku Dalam Daftar.");
        } else {
            System.out.println("Buku yang terdaftar:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();

        while (true) {
            System.out.println("\nPilih Angka Yang Anda Inginkan:");
            System.out.println("1. Tambahkan Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Daftar Buku");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Tulis Judul Buku: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Tambahkan Sinopsis: ");
                    String description = scanner.nextLine();
                    bookManager.addBook(title, description);
                    break;
                case 2:
                    System.out.print("Tuliskan Judul Buku Yang Anda Cari: ");
                    scanner.nextLine(); // Consume newline
                    String keyword = scanner.nextLine();
                    ArrayList<Book> searchResults = bookManager.searchBooks(keyword);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Hasil Pencarian:");
                        for (Book book : searchResults) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("Tidak ada deskripsi.");
                    }
                    break;
                case 3:
                    bookManager.displayBooks();
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silahkan pilih ulang");
            }
        }
    }
}
