// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.example.entities;

import java.lang.String;

privileged aspect Cage_Roo_ToString {
    
    public String Cage.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bears: ").append(getBears() == null ? "null" : getBears().size()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Name: ").append(getName());
        return sb.toString();
    }
    
}
