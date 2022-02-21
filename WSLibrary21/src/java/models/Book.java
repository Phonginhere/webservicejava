/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Phong_learning
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
    @NamedQuery(name = "Book.findByBookName", query = "SELECT b FROM Book b WHERE b.bookName = :bookName"),
    @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price"),
    @NamedQuery(name = "Book.findByDeliveredDate", query = "SELECT b FROM Book b WHERE b.deliveredDate = :deliveredDate"),
    @NamedQuery(name = "Book.findByNickname", query = "SELECT b FROM Book b WHERE b.nickname = :nickname"),
    @NamedQuery(name = "Book.findByFactory", query = "SELECT b FROM Book b WHERE b.factory = :factory")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @Column(name = "bookName")
    private String bookName;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "deliveredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveredDate;
    @Basic(optional = false)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "factory")
    private String factory;
    //begin add
    @Basic(optional = false)
    @Column(name = "authorId")
    private short authorIdd;
    //end add
    @JoinColumn(name = "authorId", referencedColumnName = "authorId")
    @ManyToOne(optional = false)
    private Author authorId;

    public Book() {
    }

    public Book(Short id) {
        this.id = id;
    }

    public Book(Short id, String bookName, float price, Date deliveredDate, String nickname, String factory, short authorIdd) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.deliveredDate = deliveredDate;
        this.nickname = nickname;
        this.factory = factory;
        this.authorIdd = authorIdd;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public short getAuthorId() {
        return authorIdd;
    }

    public void setAuthorId(short authorId) {
        this.authorIdd = authorIdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Book[ id=" + id + " ]";
    }
    
}
