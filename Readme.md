# pdf-search-regex

simple pdf search with REGEX. Promised based. Inspired by simplicity. When all you want is something simple 
nothing complex that will lead to tears, hours on 'stuck'overflow, etc...


### run:
- returns a promise

```shell
SearchPdf(<filename>, <searchTerm>, [option])
  	.then(out => {
	 console.log(out);
	})
	.catch(err =>{
	 console.log(err);
	});
```
### Option
- "--help" Help menu (manpage style)
- "--csv" Output in CSV format
- "--bool" Outputs simple 'True' or 'False" if term is found




### TODOs:
- Output JSON format


#### Requires Java Version 17 or greater

- Uses PDFBox licensed under Apache
