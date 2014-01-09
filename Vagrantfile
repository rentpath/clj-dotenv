# -*- mode: ruby -*-
# vi: set ft=ruby :

Encoding.default_external = Encoding::UTF_8
Encoding.default_internal = Encoding::UTF_8

Vagrant.configure("2") do |config|
  config.vm.hostname = "clj-dotenv"

  config.vm.box = "clj-dotenv"

  config.vm.box_url = "http://ec2-54-224-24-95.compute-1.amazonaws.com/boxes/clj-dotenv.box"

  config.vm.network :private_network, ip: "192.168.33.70"

  config.vm.network :forwarded_port, guest: 80, host: 8880, auto_correct: true

  # Immutant
  config.vm.network :forwarded_port, guest: 8080, host: 8888, auto_correct: true
  config.vm.network :forwarded_port, guest: 9990, host: 9999, auto_correct: true
  
  # Jenkins
  config.vm.network :forwarded_port, guest: 8090, host: 58090, auto_correct: true

  # ngrok
  config.vm.network :forwarded_port, guest: 4040, host: 4440, auto_correct: true

  # VNC
  config.vm.network :forwarded_port, guest: 5901, host: 5901, auto_correct: true

  config.vm.provider :virtualbox do |vb|
    # Use 1 GB memory
    vb.customize ["modifyvm", :id, "--memory", "1024"]

    # Configure the VM to use the Host DNS for the VPN
    vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
  end
end
