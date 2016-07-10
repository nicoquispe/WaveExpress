package pe.edu.utp.waveexpress.services;

import android.database.sqlite.SQLiteDatabase;

import com.orm.SugarContext;
import com.orm.SugarDb;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.edu.utp.waveexpress.models.Category;
import pe.edu.utp.waveexpress.models.Expense;
import pe.edu.utp.waveexpress.models.Income;

/**
 * Created by ORACLE on 09/07/2016.
 */
public class WaveService {
    public Boolean addExpense(String description, Double cost, Category category, String photo, Date date){
        Expense expense = new Expense();
        expense.setDescription( description );
        expense.setCost( cost );
        expense.setCategory( category );
        expense.setPhoto( photo );
        expense.setDate( date );
        return expense.save() > 0;
    }
    public List<Income> getAllIncome(  ){
        List<Income> incomes = Income.listAll( Income.class );
        return incomes ;
    }
    public List<Expense> getAllExpense(  ){
        List<Expense> expenses = Expense.listAll( Expense.class );
        return expenses ;
    }
    public Boolean addIncome(String description, Double cost, Category category, String photo, Date date){
        Income income = new Income();
        income.setDescription( description );
        income.setCost( cost );
        income.setCategory( category );
        income.setPhoto( photo );
        income.setDate( date );
        return income.save() > 0;
    }
    private SQLiteDatabase getDatabase() {
        try {
            Field f = SugarContext.getSugarContext().getClass().getDeclaredField("sugarDb");
            f.setAccessible(true);
            return ((SugarDb) f.get(SugarContext.getSugarContext())).getDB();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}


