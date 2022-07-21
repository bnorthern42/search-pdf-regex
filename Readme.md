# Search-pdf-regex

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

#### Changelog: 

- 0.3.2
	- Changed Java Version to 11 in making Jar
	- Formatted help menu to java 11 specs
- 0.3.4
	- now beta 'ish' 
	- changed child processes to child_process Sync
- 0.3.5
	- Clode cleanup
	- Better error messages
- 0.3.6
	- Downgraded to java 8 for more broad support	
	
#### Requires Java Version 8 or greater

- Uses [PDFBox](https://pdfbox.apache.org/) a project under the [Apache Software Foundation](https://apache.org/)

#### Compatibility 
- [Cypress](https://www.cypress.io/)
    - makes this usable for Cypress '.then()' etc when this lib is called as a 'task'
	- making it easy to use for a simple pdf validator

#### Notes:
- this package may change at anytime, so use at own risk
- use SpawnSync over regualar spawn due to js not wating for promise. 



