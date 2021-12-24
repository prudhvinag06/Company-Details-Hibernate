async function fetch_data(){

    alert("hi");
    let response = await fetch('api/company/view');
    let result = await response.json();
    console.log(result);

    let table_data = document.getElementById('myTable');
    table_data.innerHTML = '';

    for (let i = 0; i < result.length; i++) {
        //<th scope="row">'+(i+1)+'</th>\n
        let tr_data = document.createElement('tr');
        tr_data.innerHTML= //'<th scope="row"></th>\n' +
            '               <td>'+result[i]['company_id']+'</td>\n'+
            '               <td>'+result[i]['company_name']+'</td>\n' +
            '               <td>'+result[i]['hr_name']+'</td>\n' +
            '               <td>'+result[i]['email']+'</td>\n';
        table_data.appendChild(tr_data);

    }

}