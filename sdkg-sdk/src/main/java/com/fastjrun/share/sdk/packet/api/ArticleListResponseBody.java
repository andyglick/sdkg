
package com.fastjrun.share.sdk.packet.api;

import java.io.Serializable;
import java.util.List;
import com.fastjrun.packet.BaseBody;


/**
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的
 * 
 * @Copyright 2018 快嘉框架. All rights reserved.
 * @author cuiyingfeng
 */
public class ArticleListResponseBody
    extends BaseBody
    implements Serializable
{

    private List<Article> list;
    private final static long serialVersionUID = 454033750L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(("ArticleListResponseBody"+" ["));
        sb.append("list [");
        sb.append("list");
        sb.append("=");
        if (this.list!= null) {
            for (int i = 0; (i<this.list.size()); i ++) {
                Article article = this.list.get(i);
                if (i == 0) {
                    sb.append("[");
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("list.");
                sb.append(i);
                sb.append("=");
                sb.append(article);
            }
            sb.append("]");
        } else {
            sb.append("null");
        }
        sb.append("]");
        sb.append("]");
        return sb.toString();
    }

    public void setList(List<Article> list) {
        this.list = list;
    }

    public List<Article> getList() {
        return this.list;
    }

}
