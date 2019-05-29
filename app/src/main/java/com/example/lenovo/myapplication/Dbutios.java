package com.example.lenovo.myapplication;

import com.example.lenovo.myapplication.dao.BeanDao;
import com.example.lenovo.myapplication.dao.DaoMaster;
import com.example.lenovo.myapplication.dao.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class Dbutios {
    private static Dbutios dbutios;
    private final BeanDao beanDao;

    public Dbutios() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(),"inoe.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        beanDao = daoSession.getBeanDao();
    }

    public static Dbutios getDbutios() {
        if (dbutios == null){
            synchronized (Dbutios.class){
                if (dbutios == null){
                    dbutios = new Dbutios();
                }
            }
        }
        return dbutios;
    }

    public void insertAll(ArrayList<Bean> list){
        if (!has())
            beanDao.insertOrReplaceInTx(list);
    }

    public void insert (Bean bean) {
        beanDao.insertOrReplace(bean);
    }


    public void delete(Bean bean){
        beanDao.delete(bean);
    }

    public List<Bean> query(){
        return beanDao.queryBuilder().list();
    }

    private boolean has() {
        List<Bean> list = beanDao.queryBuilder().list();
        if (list != null && list.size()>0){
            return true;
        }
        return false;
    }
}
