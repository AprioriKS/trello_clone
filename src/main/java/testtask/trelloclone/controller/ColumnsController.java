package testtask.trelloclone.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testtask.trelloclone.dto.request.ColumnsRequestDto;
import testtask.trelloclone.dto.response.ColumnsResponseDto;
import testtask.trelloclone.model.Column;
import testtask.trelloclone.service.ColumnService;
import testtask.trelloclone.service.mapper.ColumnsMapper;

@RequiredArgsConstructor
@RestController
@RequestMapping("/column")
public class ColumnsController {
    private final ColumnService columnService;
    private final ColumnsMapper columnsMapper;

    @GetMapping("/{id}")
    public ColumnsResponseDto getById(@PathVariable Long id) {
        Column column = columnService.findById(id);
        return columnsMapper.mapToDto(column);
    }

    @PostMapping
    public ColumnsResponseDto save(@RequestBody ColumnsRequestDto columnsRequestDto) {
        Column column = columnsMapper.mapToModel(columnsRequestDto);
        Column savedColumn = columnService.save(column);
        return columnsMapper.mapToDto(savedColumn);
    }

    @PutMapping("/{id}")
    public ColumnsResponseDto update(@PathVariable Long id,
        @RequestBody ColumnsRequestDto columnsRequestDto) {
        Column column = columnsMapper.mapToModel(columnsRequestDto);
        column.setId(id);
        return columnsMapper.mapToDto(columnService.save(column));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        columnService.deleteById(id);
    }

    @PostMapping("/changeorder")
    public String changeOrder(@RequestParam Long idFrom,
        @RequestParam Long idTo) {
        columnService.changeOrder(idFrom, idTo);
        return "Order change successful";
    }

    @GetMapping("/all")
    public List<ColumnsResponseDto> getAll() {
        return columnService.getAll().stream()
            .map(columnsMapper::mapToDto)
            .collect(Collectors.toList());
    }

}
