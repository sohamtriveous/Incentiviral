
package com.incentiviral.android.model.list;

import com.google.gson.annotations.Expose;

public class Reward {

    @Expose
    private String title;
    @Expose
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
