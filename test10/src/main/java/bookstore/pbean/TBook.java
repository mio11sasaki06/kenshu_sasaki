package bookstore.pbean;

public class TBook {
int id;
String isbn;
String title;
String author;
String published;
int price;

public int getId(){
	return id;
}
public void setId(int id){
	this.id = id;
}
public String getTitle(){
	return title;
}
public void setTitle(String title){
	this.title = title;
}
public String getIsbn(){
	return isbn;
}
public void setIsbn(String isbn){
	this.isbn = isbn;
}

public String getAuthor(){
	return author;
}
public void setAuthor(String author){
	this.author = author;
}
public int getPrice(){
	return price;
}
public void setPrice(int price){
	this.price = price;
}

public void setPublished(String published){
	this.published = published;
}
public String getPublished(){
	return published;
}

}
