package controller;

import dto.CursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CursoService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDto> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping
    public void salvarCurso(@RequestBody CursoDto cursoDto) {
        cursoService.salvarCurso(cursoDto);
    }

    @DeleteMapping
    public void deletarCurso(@RequestParam Long id) {
        cursoService.deletarCurso(id);
    }

    @PutMapping
    public void atualizarCurso(@RequestParam Long id, @RequestBody CursoDto cursoDto) {
        cursoService.atualizarCurso(id, cursoDto);
    }
}
