package com.booboil.auth.utils;

import com.booboil.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {
    //使用递归方法建菜单
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> trees = new ArrayList<>();
        //把所有菜单数据进行遍历
        for(SysMenu sysMenu:sysMenuList) {
            //递归入口进入 parentId=0是入口
            if(sysMenu.getParentId() == 0) {
                trees.add(getChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }

    public static SysMenu getChildren(SysMenu sysMenu, List<SysMenu> sysMenuList) {
        List<SysMenu> children = new ArrayList<>();
        //遍历所有菜单数据，判断 id 和 parentId对应关系
        for(SysMenu it: sysMenuList) {
            if(sysMenu.getId() == it.getParentId()) {
                SysMenu child = getChildren(it, sysMenuList);
                children.add(child);
            }
        }
        sysMenu.setChildren(children);
        return sysMenu;
    }
}
