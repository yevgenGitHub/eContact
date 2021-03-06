package org.econtact.data.model.entity.account;

import org.econtact.data.model.entity.AbstractEntity;
import org.econtact.data.DataModelHelper;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PERSON", schema = DataModelHelper.ECONTACT_SCHEMA)
@Audited
@AuditTable(value = "PERSON_AUDIT", schema = DataModelHelper.ECONTACT_SCHEMA)
public class PersonEntity extends AbstractEntity<Long> {

    private static final String SEQ_NAME = "personSeq";
    private static final long serialVersionUID = -3799729034150189729L;

    @SequenceGenerator(name = SEQ_NAME, sequenceName = "S$PERSON_SEQ", schema = DataModelHelper.ECONTACT_SCHEMA, allocationSize = 1)
    @Id
    @Column(name = "ID_PERSON", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    private Long id;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "ROLE_TYPE")
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }
}
