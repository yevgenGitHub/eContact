package org.econtact.data.context;

import java.io.Serializable;

public class EnversContext implements Serializable {
    private static final long serialVersionUID = -7721180592331014931L;
    private String note;
    private String nameEv;

    public static EnversContext create(String nameEv, String note) {
        final EnversContext result = new EnversContext();
        result.nameEv = nameEv;
        result.note = note;
        return result;
    }

    public String getNote() {
        return note;
    }

    public String getNameEv() {
        return nameEv;
    }
}
