package mybase.controllers;

import lombok.AllArgsConstructor;
import mybase.domain.UserAccount;
import mybase.domain.dto.GoalDto;
import mybase.domain.dto.NewGoalDto;
import mybase.domain.types.GoalType;
import mybase.services.GoalsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/goals")
@AllArgsConstructor
public class GoalsController {
    private final GoalsService goalsService;

    @PostMapping("/add/new")
    @Transactional
    public GoalDto addNewGoal(@RequestBody NewGoalDto newGoalDto,
                              @AuthenticationPrincipal UserAccount userAccount/*MainUser mainUser*/
    ) {
        return goalsService.addNewGoal(newGoalDto, userAccount);
    }

    @GetMapping("/load/all")
    public List<GoalDto> loadAllGoals(@AuthenticationPrincipal UserAccount accountUser) {
        return goalsService.loadGoalsByUser(accountUser);
    }

    @GetMapping("/load/types")
    public Set<GoalType> loadAllGoalTypes() {
        return goalsService.loadAllGoalTypes();
    }

}
