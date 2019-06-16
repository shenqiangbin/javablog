package com.sqber.blog.service;

import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.model.Cartoon;
import com.sqber.blog.model.CartoonJi;
import com.sqber.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartoonService {

    @Autowired
    private SQLHelper sqlHelper;

    public String getOverview() {

        StringBuilder builder = new StringBuilder();

        try {
            List<Cartoon> cartoons = getLatest();
            String cartoonDesc = toString(cartoons);

            List<CartoonJi> cartoonJis = getLatestJi();
            String cartoonJiDesc = toStringJI(cartoonJis);

            builder.append("动漫总数：").append(getCartoonCount()).append("\r\n")
                    .append("动漫集数总共有：").append(getCartoonJiCount()).append("\r\n")
                    .append("有地址的有：").append(getHasSrcJi()).append("\r\n")
                    .append("最近同步的动漫：").append(cartoonDesc).append("\r\n")
                    .append("最近获取的地址有").append(cartoonJiDesc);
        } catch (Exception e) {
            System.out.println(e);
        }

        return builder.toString();
    }

    private String toString(List<Cartoon> cartoons) {
        StringBuilder builder = new StringBuilder();
        for (Cartoon c : cartoons) {
            builder.append(c.getName()).append("\r\n").append(c.getUpdateTime()).append("\r\n");
        }
        return builder.toString();
    }

    private String toStringJI(List<CartoonJi> jis) {

        List<String> jiCIdList = jis.stream().map(m -> String.valueOf(m.getCartoonId())).collect(Collectors.toList());
        List<Cartoon> cartoons = getByIds(jiCIdList);

        StringBuilder builder = new StringBuilder();
        for (CartoonJi c : jis) {

            String cartoonName = "";
            for (Cartoon car : cartoons) {
                if (car.getId() == c.getCartoonId())
                    cartoonName = car.getName();
            }

            builder.append(cartoonName).append("\r\n")
                    .append(c.getJiName()).append("\r\n")
                    .append(c.getLinename()).append("r\n")
                    .append(c.getUpdateTime()).append("\r\n");
        }
        return builder.toString();
    }

    public long getCartoonCount() {
        String sql = "SELECT count(0) from cartoon";
        String val = sqlHelper.executeScalar(sql, null);
        return Long.parseLong(val);
    }

    public Cartoon getById(Integer id) {
        String sql = "SELECT * from cartoon where status = 1 and id = " + id;

        List<Cartoon> list = sqlHelper.query(sql, null, Cartoon.class);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    public List<Cartoon> getByName(String cartoonName) {
        String sql = "SELECT * from cartoon where status = 1 and name like ?";
        List<Object> params = new ArrayList<>();
        params.add("%" + cartoonName + "%");

        List<Cartoon> list = sqlHelper.query(sql, params, Cartoon.class);
        return list;
    }

    public List<Cartoon> getByIds(List<String> ids) {
        String sql = "SELECT * from cartoon where id in (" + String.join(",", ids) + ")";

        List<Cartoon> list = sqlHelper.query(sql, null, Cartoon.class);
        return list;
    }

    public List<Cartoon> getLatest() {
        String sql = "SELECT * from cartoon order by updatetime desc limit 0,10";

        List<Cartoon> list = sqlHelper.query(sql, null, Cartoon.class);
        return list;
    }

    public long getCartoonJiCount() {
        String sql = "SELECT count(0) from cartoonJi";
        String val = sqlHelper.executeScalar(sql, null);
        return Long.parseLong(val);
    }

    public long getHasSrcJi() {
        String sql = "select count(0) from cartoonji where truesrc != ''";
        String val = sqlHelper.executeScalar(sql, null);
        return Long.parseLong(val);
    }

    public List<CartoonJi> getLatestJi() {
        String sql = "SELECT * from cartoonji order by updatetime desc limit 0,10";

        List<CartoonJi> list = sqlHelper.query(sql, null, CartoonJi.class);
        return list;
    }

    public List<CartoonJi> getByCartoonId(Integer cartoonid) {
        String sql = "SELECT * from cartoonji where status = 1 and cartoonId = " + cartoonid;

        List<CartoonJi> list = sqlHelper.query(sql, null, CartoonJi.class);
        return list;
    }

    public void makeItNew(String cartoonid) {
        String sql = "update cartoonji set createtime = now() where status = 1 and cartoonId = " + cartoonid;
        sqlHelper.update(sql, null);
    }
}
