package com.example.BiblioTeca.model;

public class Book{
    private String bookName = "N/A";
    private String author = "N/A";
    private String publicationYear = "N/A";

    public Book() {
    }
    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String author, String publicationYear) {
        this.bookName = bookName;
        if(author != null)
            this.author = author;
        if(publicationYear != null)
            this.publicationYear = publicationYear;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book)obj;
        if(this.bookName.equalsIgnoreCase(book.bookName))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
