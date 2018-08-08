/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_allocator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Joseph
 */
@Entity
@Table(name = "lended", catalog = "library_manager", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lended.findAll", query = "SELECT l FROM Lended l")
    , @NamedQuery(name = "Lended.findByMatricOrId", query = "SELECT l FROM Lended l WHERE l.matricOrId = :matricOrId")
    , @NamedQuery(name = "Lended.findById", query = "SELECT l FROM Lended l WHERE l.id = :id")
    , @NamedQuery(name = "Lended.findByBookTitle", query = "SELECT l FROM Lended l WHERE l.bookTitle = :bookTitle")
    , @NamedQuery(name = "Lended.findByDateCollected", query = "SELECT l FROM Lended l WHERE l.dateCollected = :dateCollected")
    , @NamedQuery(name = "Lended.findByReturnDate", query = "SELECT l FROM Lended l WHERE l.returnDate = :returnDate")
    , @NamedQuery(name = "Lended.findByStatus", query = "SELECT l FROM Lended l WHERE l.status = :status")})
public class Lended implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "matric_or_id")
    private String matricOrId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "book_title")
    private String bookTitle;
    @Basic(optional = false)
    @Column(name = "date_collected")
    private String dateCollected;
    @Basic(optional = false)
    @Column(name = "return_date")
    private String returnDate;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;

    public Lended() {
    }

    public Lended(Integer id) {
        this.id = id;
    }

    public Lended(Integer id, String matricOrId, String bookTitle, String dateCollected, String returnDate, boolean status) {
        this.id = id;
        this.matricOrId = matricOrId;
        this.bookTitle = bookTitle;
        this.dateCollected = dateCollected;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getMatricOrId() {
        return matricOrId;
    }

    public void setMatricOrId(String matricOrId) {
        String oldMatricOrId = this.matricOrId;
        this.matricOrId = matricOrId;
        changeSupport.firePropertyChange("matricOrId", oldMatricOrId, matricOrId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        String oldBookTitle = this.bookTitle;
        this.bookTitle = bookTitle;
        changeSupport.firePropertyChange("bookTitle", oldBookTitle, bookTitle);
    }

    public String getDateCollected() {
        return dateCollected;
    }

    public void setDateCollected(String dateCollected) {
        String oldDateCollected = this.dateCollected;
        this.dateCollected = dateCollected;
        changeSupport.firePropertyChange("dateCollected", oldDateCollected, dateCollected);
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        String oldReturnDate = this.returnDate;
        this.returnDate = returnDate;
        changeSupport.firePropertyChange("returnDate", oldReturnDate, returnDate);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        boolean oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
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
        if (!(object instanceof Lended)) {
            return false;
        }
        Lended other = (Lended) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "library_allocator.Lended[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
