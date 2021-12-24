let delete_form = document.getElementById('student-validation');
//window.onload = fetch_courses;
console.log(delete_form);
delete_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (delete_form.checkValidity() === true) {
        let response = await fetch('api/company/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
            })
        });
        let result = await response;
        console.log(result);
    }
    delete_form.classList.add('was-validated');
});