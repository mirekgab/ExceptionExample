package pl.mirekgab.exceptionexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mirekgab.exceptionexample.model.Income;
import pl.mirekgab.exceptionexample.service.IncomeService;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncome();
    }

    @GetMapping("/{id}")
    public Income getIncome(@PathVariable Long id) {
        return incomeService.getIncome(id);
    }
}
