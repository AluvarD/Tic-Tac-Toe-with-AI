import java.util.Arrays;
import java.util.Scanner;

class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        // write your code here
        return getType() + getDetails();
    }

    public String getType() {
        return "Publication: ";
    }

    public String getDetails() {
        return this.title;
    }

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    // write your code here

    @Override
    public String getType() {
        return "Newspaper (source - " + this.source + "): ";
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }


}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    // write your code here

    @Override
    public String getType() {
        return "Article (author - " + this.author + "): ";
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    // write your code here

    @Override
    public String getType() {
        return "Announcement (days to expire - " + this.daysToExpire + "): ";
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
}

/*class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split("; ");
        System.out.println(Arrays.toString(inputArr));
        if (inputArr[0].equals("Publication")) {
            Publication publication = new Publication(inputArr[1]);
            System.out.println(publication.getInfo());
        } else if (inputArr[0].equals("Newspaper")) {
            Publication newspaper = new Newspaper(inputArr[1], inputArr[2]);
            System.out.println(newspaper.getInfo());
        } else if (inputArr[0].equals("Article")) {
            Publication article = new Article(inputArr[1], inputArr[2]);
            System.out.println(article.getInfo());
        } else if (inputArr[0].equals("Announcement")) {
            Publication announcement = new Announcement(inputArr[1], Integer.getInteger(inputArr[2]));
            System.out.println(announcement.getInfo());
        }
    }
}*/