package controller;

import dto.AlunoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AlunoService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoDto> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @PostMapping
    public void salvarAluno(@RequestBody AlunoDto alunoDto) {
        alunoService.salvarAluno(alunoDto);
    }

    @DeleteMapping
    public void deletarAluno(@RequestParam Long id) {
        alunoService.deletarAluno(id);
    }

    @PutMapping
    public void atualizarAluno(@RequestParam Long id, @RequestBody AlunoDto alunoDto) {
        alunoService.atualizarAluno(id, alunoDto);
    }
}
