/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Menja
 */
@Entity
@DiscriminatorValue("Ebook")
public class EBook extends Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String downloadURL;
    
    @Column
    private double sizeMB;  

}
