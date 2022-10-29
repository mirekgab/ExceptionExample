package pl.mirekgab.exceptionexample.service;

import org.springframework.stereotype.Service;
import pl.mirekgab.exceptionexample.exception.AppRuntimeException;
import pl.mirekgab.exceptionexample.exception.ExceptionMessage;
import pl.mirekgab.exceptionexample.model.Income;

import java.util.Arrays;
import java.util.List;

@Service
public class IncomeService {
    List<Income> list = Arrays.asList(
            new Income(1L, "income1"),
            new Income(2L, "income2"));

    public List<Income> getAllIncome() {
        return list;
    }

    public Income getIncome(Long id) {
        return list.stream().filter(i->id.equals(i.getId())).findFirst().orElseThrow(()->
                new AppRuntimeException(ExceptionMessage.CODE_NOT_FOUND, ExceptionMessage.STATUS_INCOME_NOT_FOUND));
    }
}
