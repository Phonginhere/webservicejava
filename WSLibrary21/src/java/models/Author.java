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
@Table(name = "author")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId"),
    @NamedQuery(name = "Author.findByAuthorName", query = "SELECT a FROM Author a WHERE a.authorName = :authorName"),
    @NamedQuery(name = "Author.findByBirthday", query = "SELECT a FROM Author a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Author.findByAddress", query = "SELECT a FROM Author a WHERE a.address = :address"),
    @NamedQuery(name = "Author.findByNickname", query = "SELECT a FROM Author a WHERE a.nickname = :nickname")})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authorId")
    private Short authorId;
    @Basic(optional = false)
    @Column(name = "authorName")
    private String authorName;
    @Basic(optional = false)
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "nickname")
    private String nickname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private Collection<Book> bookCollection;

    public Author() {
    }

    public Author(Short authorId) {
        this.authorId = authorId;
    }

    public Author(Short authorId, String authorName, Date birthday, String address, String nickname) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.birthday = birthday;
        this.address = address;
        this.nickname = nickname;
    }
    
     public Author(String authorName, Date birthday, String address, String nickname) {
        this.authorName = authorName;
        this.birthday = birthday;
        this.address = address;
        this.nickname = nickname;
    }

    public Short getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Short authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorId != null ? authorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorId == null && other.authorId != null) || (this.authorId != null && !this.authorId.equals(other.authorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Author[ authorId=" + authorId + " ]";
    }
    
}
