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
 * @author ALLAH NA MU
 */
@Entity
@Table(name = "resources", catalog = "library_manager", schema = "")
@NamedQueries({
    @NamedQuery(name = "Resources.findAll", query = "SELECT r FROM Resources r")
    , @NamedQuery(name = "Resources.findById", query = "SELECT r FROM Resources r WHERE r.id = :id")
    , @NamedQuery(name = "Resources.findByType", query = "SELECT r FROM Resources r WHERE r.type = :type")
    , @NamedQuery(name = "Resources.findByResourceId", query = "SELECT r FROM Resources r WHERE r.resourceId = :resourceId")
    , @NamedQuery(name = "Resources.findByTitle", query = "SELECT r FROM Resources r WHERE r.title = :title")
    , @NamedQuery(name = "Resources.findByCopies", query = "SELECT r FROM Resources r WHERE r.copies = :copies")
    , @NamedQuery(name = "Resources.findByAvailability", query = "SELECT r FROM Resources r WHERE r.availability = :availability")})
public class Resources implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "resource_id")
    private String resourceId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "copies")
    private int copies;
    @Basic(optional = false)
    @Column(name = "availability")
    private boolean availability;

    public Resources() {
    }

    public Resources(Integer id) {
        this.id = id;
    }

    public Resources(Integer id, String type, String resourceId, String title, int copies, boolean availability) {
        this.id = id;
        this.type = type;
        this.resourceId = resourceId;
        this.title = title;
        this.copies = copies;
        this.availability = availability;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        String oldResourceId = this.resourceId;
        this.resourceId = resourceId;
        changeSupport.firePropertyChange("resourceId", oldResourceId, resourceId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        int oldCopies = this.copies;
        this.copies = copies;
        changeSupport.firePropertyChange("copies", oldCopies, copies);
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        boolean oldAvailability = this.availability;
        this.availability = availability;
        changeSupport.firePropertyChange("availability", oldAvailability, availability);
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
        if (!(object instanceof Resources)) {
            return false;
        }
        Resources other = (Resources) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "library_allocator.Resources[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
