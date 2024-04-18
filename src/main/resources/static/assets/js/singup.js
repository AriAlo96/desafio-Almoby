const app = Vue.createApp({
    data() {
        return {
            fullName: "",
            email: "",
            password: "",
            confirmPassword: "",
            errorMessage: "",
            showSpinnerRegister: false,
            agreedToTerms: false
        };
    },

    created() {

    },
    methods: {
        register() {
            Swal.fire({
                title: 'Do you want to register?',
                showCancelButton: true,
                cancelButtonText: 'Cancel',
                confirmButtonText: 'Register',
                confirmButtonColor: '#473BF0',
                cancelButtonColor: '#161C2D',
                showClass: {
                    popup: 'swal2-noanimation',
                    backdrop: 'swal2-noanimation'
                },
                hideClass: {
                    popup: '',
                    backdrop: ''
                }, 
                preConfirm: () => {
                    this.showSpinnerRegister = true;
                    axios.post('/api/persons', `fullName=${this.fullName}&email=${this.email}&password=${this.password}&confirmPassword=${this.confirmPassword}`)
                    .then(response => {
                        Swal.fire({
                            position: "center",
                            icon: "success",
                            title: "Successful register",
                            showConfirmButton: false,
                            timer: 1500,
                        }),
                            setTimeout(() => {
                                location.pathname = "/index.html";
                            }, 1600);
                    })
                        .catch(error => {
                            this.errorMessage = error.response.data
                            Swal.fire({
                                icon: 'error',
                                title: 'Error',
                                html: errorMessage,
                            });
                        })
                        .finally(() => {
                            this.showSpinnerRegister = false;
                          });
                }
            });
        }
    }
})
app.mount('#app');